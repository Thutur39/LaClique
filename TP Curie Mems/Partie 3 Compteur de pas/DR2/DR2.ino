#include <CurieIMU.h>

boolean stepEventsEnabeled = false;
long lastStepCount = 0;
boolean blinkState = false;

void setup() {
  // put your setup code here, to run once:
  pinMode(13, OUTPUT);

  Serial.begin(9600);
  while (!Serial);

  CurieIMU.begin();
  CurieIMU.setStepDetectionMode(CURIE_IMU_STEP_MODE_NORMAL);
  CurieIMU.setStepCountEnabled(true);
  if (stepEventsEnabeled) {
    CurieIMU.attachInterrupt(eventCallback);
    CurieIMU.interrupts(CURIE_IMU_STEP);

    Serial.println("Initialisation de l'IMU terminée, attente d'un évenement ....");
  }
}

void loop() {
  // put your main code here, to run repeatedly:
  if (!stepEventsEnabeled) {
    updateStepCount();
  }
  digitalWrite(13, blinkState);
  blinkState = !blinkState;
  delay(3000);
}

static void updateStepCount() {
  int stepCount = CurieIMU.getStepCount();

  if (stepCount != lastStepCount) {
    Serial.print("Compteur de pas : ");
    Serial.println(stepCount);
    lastStepCount = stepCount;
  }
}

static void eventCallback(void) {
  if (CurieIMU.stepsDetected()) {
    updateStepCount();
  }
}

