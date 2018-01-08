#include<CurieIMU.h>

/* Fonction setup (Initialisation) */
void setup()
{
  Serial.begin(9600);           // Initialisation de la liaison série
  while(!Serial);               // Attente d'ouverture de la liaison série

  // Initialisation de l'accéléromètre
  Serial.println("Initializing IMU device ...");
  CurieIMU.begin();

  // Paramétrage de l'accéléromètre à l'échelle de 2G
  CurieIMU.setAccelerometerRange(2);
}

/* Fonction loop (boucle sans fin) */
void loop()
{
  float ax,ay,az;      // Valeur de l'accéléromètre x/y/z

  // Lecture des mesures données par l'accéléromètre, avec les échelles configurées
  CurieIMU.readAccelerometerScaled(ax,ay,az);

  // Affichage séparé des valeurs de l'accéléromètre x/y/z
  Serial.print("a:\t");
  Serial.print(ax);
  Serial.print("\t");
  Serial.print(ay);  
  Serial.print("\t");
  Serial.print(az);
  Serial.println();  
  delay (1000);            
}

