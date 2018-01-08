#include <CurieIMU.h>

boolean blinkState = false;

void setup() {
  // put your setup code here, to run once:
  pinMode(13, OUTPUT);

  Serial.begin(9600);
  while (!Serial);

  CurieIMU.begin();
  CurieIMU.attachInterrupt(eventCallback);
  CurieIMU.setDetectionThreshold(CURIE_IMU_SHOCK, 5000);
  CurieIMU.setDetectionDuration(CURIE_IMU_SHOCK, 500);
  CurieIMU.interrupts(CURIE_IMU_SHOCK);

  Serial.println("Initialisation de l'IMU terminée, attente d'un évenement ....");
}

void loop() {
  // put your main code here, to run repeatedly:
  digitalWrite(13, blinkState);
  blinkState = !blinkState;
  delay(500);
}

static void eventCallback(void) {
  if (CurieIMU.getInterruptStatus(CURIE_IMU_SHOCK)) {
    if (CurieIMU.shockDetected(X_AXIS, POSITIVE))
      Serial.println("Choc sur l'axe X dans le sens positif !");
    if (CurieIMU.shockDetected(X_AXIS, NEGATIVE))
      Serial.println("Choc sur l'axe X dans le sens positif !");
    if (CurieIMU.shockDetected(Y_AXIS, POSITIVE))
      Serial.println("Choc sur l'axe Y dans le sens positif !");
    if (CurieIMU.shockDetected(Y_AXIS, NEGATIVE))
      Serial.println("Choc sur l'axe Y dans le sens positif !");
    if (CurieIMU.shockDetected(Z_AXIS, POSITIVE))
      Serial.println("Choc sur l'axe Z dans le sens positif !");
    if (CurieIMU.shockDetected(Z_AXIS, NEGATIVE))
      Serial.println("Choc sur l'axe Z dans le sens positif !");
  }
}

