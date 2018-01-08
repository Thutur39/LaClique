#include <CurieIMU.h>

/* Fonction Setup (Initialisation) */
void setup()
{
  Serial.begin(9600);                    // Initialisation de la liaison série
  while (!Serial);                       // Attente d'ouverture de la liaison série

  // Initialisation du gyroscope
  Serial.println("Initializing IMU device ...");
  CurieIMU.begin();

  // Paramétrage de l'échelle du gyroscope à 250 degrès / secondes
  CurieIMU.setGyroRange(250);
}
/* Fonction loop (boucle sans fin) */
void loop()
{
  float gx, gy, gz;                       // Valeurs du groupe x/y/z

  // Lecture des mesures données par le gyroscope, avec les échelles configurées
  CurieIMU.readGyroScaled (gx, gy, gz);

  // Affichage séparé des valeurs du gyroscope x/y/z
  Serial.print ("g:\t");
  Serial.print (gx);
  Serial.print ("\t");
  Serial.print (gy);
  Serial.print ("\t");
  Serial.print (gz);
  Serial.println ();
  delay(750);
}

