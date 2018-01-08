#include <CurieBLE.h>
#include <CurieIMU.h>

boolean stepEventsEnabeled = false;
long lastStepCount = 0;
boolean blinkState = false;
BLEPeripheral blePeripheral;
BLEService stepService("1814");

//bluetooh Low Energy caractéristiques
BLECharacteristic stepCountChar("2ACF", BLERead | BLENotify, 2);
int oldPas = 0;
long previousMillis = 0;

void setup() {
  pinMode(13, OUTPUT);

  Serial.begin(9600);

  CurieIMU.begin();
  CurieIMU.setStepDetectionMode(CURIE_IMU_STEP_MODE_NORMAL);
  CurieIMU.setStepCountEnabled(true);
  if (stepEventsEnabeled) {
    CurieIMU.attachInterrupt(eventCallback);
    CurieIMU.interrupts(CURIE_IMU_STEP);

    Serial.println("Initialisation de l'IMU terminée, attente d'un évenement ....");
  }

  blePeripheral.setLocalName("ThuturTP Step");

  blePeripheral.setAdvertisedServiceUuid(stepService.uuid());
  blePeripheral.addAttribute(stepService);
  blePeripheral.addAttribute(stepCountChar);

  blePeripheral.begin();
}

void loop() {
  BLECentral central = blePeripheral.central(); //Numéro de connexion

  if (central) { //test si connexion a lieu
    //oui
    digitalWrite(13, HIGH);
    while (central.connected()) { //tant qu'on est co

      long currentMillis = millis();
      if (currentMillis - previousMillis >= 200)
      {
        previousMillis = currentMillis;
        updateStepCount();
      }
    }
    digitalWrite(13, LOW);
    blinkState = !blinkState;
  }
}

static void updateStepCount() {
  char stepCount = CurieIMU.getStepCount();

  if (stepCount != lastStepCount) {
    const unsigned char stepCountCharArray[2] = {0, (char)stepCount};
    stepCountChar.setValue(stepCountCharArray, 2);
    lastStepCount = stepCount;
  }
}

static void eventCallback(void) {
  if (CurieIMU.stepsDetected()) {
    updateStepCount();
  }
}
