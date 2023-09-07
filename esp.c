#include <WiFi.h>
#include <HTTPClient.h>
#include <OneWire.h>
#include <DallasTemperature.h>
#include <ArduinoJson.h>

const char* ssid = "jao";
const char* password = "123456789";

const char* serverName = "http://192.168.47.64:1880/update-sensor";

#define ONE_WIRE_BUS_1 12
#define ONE_WIRE_BUS_2 13
#define ONE_WIRE_BUS_3 15
#define ONE_WIRE_BUS_4 17
#define ONE_WIRE_BUS_5 4
#define ONE_WIRE_BUS_6 23
#define ONE_WIRE_BUS_7 22
#define ONE_WIRE_BUS_8 19
#define ONE_WIRE_BUS_9 21
#define ONE_WIRE_BUS_10 18

#define SIG 32
#define S0 14
#define S1 27
#define S2 26
#define S3 25

int mix[4]={S3,S2,S1,S0};
int valores_analogicos[16];


byte ci[16][4]={
  {0,0,0,0},  //0
  {0,0,0,1},  //1
  {0,0,1,0},  //2
  {0,0,1,1},  //3
  {0,1,0,0},  //4
  {0,1,0,1},  //5
  {0,1,1,0},  //6
  {0,1,1,1},  //7
  {1,0,0,0},  //8
  {1,0,0,1},  //9
  };
  
OneWire oneWire1(ONE_WIRE_BUS_1);
OneWire oneWire2(ONE_WIRE_BUS_2);
OneWire oneWire3(ONE_WIRE_BUS_3);
OneWire oneWire4(ONE_WIRE_BUS_4);
OneWire oneWire5(ONE_WIRE_BUS_5);
OneWire oneWire6(ONE_WIRE_BUS_6);
OneWire oneWire7(ONE_WIRE_BUS_7);
OneWire oneWire8(ONE_WIRE_BUS_8);
OneWire oneWire9(ONE_WIRE_BUS_9);
OneWire oneWire10(ONE_WIRE_BUS_10);

DallasTemperature sensors1(&oneWire1);
DallasTemperature sensors2(&oneWire2);
DallasTemperature sensors3(&oneWire3);
DallasTemperature sensors4(&oneWire4);
DallasTemperature sensors5(&oneWire5);
DallasTemperature sensors6(&oneWire6);
DallasTemperature sensors7(&oneWire7);
DallasTemperature sensors8(&oneWire8);
DallasTemperature sensors9(&oneWire9);
DallasTemperature sensors10(&oneWire10);

const int numSensors = 10;
float temperatureReadings[numSensors];
float soilHumidityReadings[numSensors];
int outputValue[numSensors];

unsigned long lastTime = 0;
unsigned long timerDelay = 5000;

void setup() {
  Serial.begin(115200);

  pinMode(S0,OUTPUT);
  pinMode(S1,OUTPUT);
  pinMode(S2,OUTPUT);
  pinMode(S3,OUTPUT);
  pinMode(SIG,INPUT);
  
  digitalWrite(S0, LOW);
  digitalWrite(S1, LOW);
  digitalWrite(S2, LOW);
  digitalWrite(S3, LOW);
  
  sensors1.begin();
  sensors2.begin();
  sensors3.begin();
  sensors4.begin();
  sensors5.begin();
  sensors6.begin();
  sensors7.begin();
  sensors8.begin();
  sensors9.begin();
  sensors10.begin();

  WiFi.begin(ssid, password);
  Serial.println("Connecting");
  while(WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.print("Connected to WiFi network with IP Address: ");
  Serial.println(WiFi.localIP());
 
  Serial.println("Timer set to 5 seconds (timerDelay variable), it will take 5 seconds before publishing the first reading.");
}

void loop() {

    multiplex();

  sensors1.requestTemperatures(); 
  temperatureReadings[0] = sensors1.getTempCByIndex(0);
  soilHumidityReadings[0] =(valores_analogicos[0]);
 // outputValue[0] = map(soilHumidityReadings[0], 4095, 2250, 0, 100);
  
  sensors2.requestTemperatures(); 
  temperatureReadings[1] = sensors2.getTempCByIndex(0);
  soilHumidityReadings[1] =(valores_analogicos[1]);
  //outputValue[1] = map(soilHumidityReadings[1], 4095, 2250, 0, 100);

  sensors3.requestTemperatures(); 
  temperatureReadings[2] = sensors3.getTempCByIndex(0);
  soilHumidityReadings[2] =(valores_analogicos[2]);
  //outputValue[2] = map(soilHumidityReadings[2], 4095, 22500, 0, 100);

  sensors4.requestTemperatures(); 
  temperatureReadings[3] = sensors4.getTempCByIndex(0);
  soilHumidityReadings[3] = (valores_analogicos[3]);
  //outputValue[3] = map(soilHumidityReadings[3], 4095, 2250, 0, 100);

  sensors5.requestTemperatures(); 
  temperatureReadings[4] = sensors5.getTempCByIndex(0);
 soilHumidityReadings[4] = (valores_analogicos[4]);
  //outputValue[4] = map(soilHumidityReadings[4], 4095, 2250, 0, 100);

  sensors6.requestTemperatures(); 
  temperatureReadings[5] = sensors6.getTempCByIndex(0);
  soilHumidityReadings[5] =(valores_analogicos[5]);
 // outputValue[5] = map(soilHumidityReadings[5], 4095, 2250, 0, 100);

  sensors7.requestTemperatures(); 
  temperatureReadings[6] = sensors7.getTempCByIndex(0);
  soilHumidityReadings[6] =(valores_analogicos[6]);
  //outputValue[6] = map(soilHumidityReadings[6], 4095, 2250, 0, 100);

  sensors8.requestTemperatures(); 
  temperatureReadings[7] = sensors8.getTempCByIndex(0);
  soilHumidityReadings[7] =(valores_analogicos[7]);
  //outputValue[7] = map(soilHumidityReadings[7], 4095, 2250, 0, 100);

  sensors9.requestTemperatures(); 
  temperatureReadings[8] = sensors9.getTempCByIndex(0);
  soilHumidityReadings[8] =(valores_analogicos[8]);
  //outputValue[8] = map(soilHumidityReadings[8], 4095, 2250, 0, 100);

  sensors10.requestTemperatures(); 
  temperatureReadings[9] = sensors10.getTempCByIndex(0);
  soilHumidityReadings[9] = (valores_analogicos[9]);
  //outputValue[9] = map(soilHumidityReadings[9], 4095, 2250, 0, 100);
  
  if ((millis() - lastTime) > timerDelay) {
    if (WiFi.status() == WL_CONNECTED) {
      WiFiClient client;
      HTTPClient http;
    
      http.begin(client, serverName);
      http.addHeader("Content-Type", "application/json");

      // Criar o objeto JSON
      StaticJsonDocument<2200> jsonDoc;

      // Adicionar os campos ao objeto JSON
      for (int i = 0; i < numSensors; i++) {
        JsonObject sensorObj = jsonDoc.createNestedObject("Sensor de Temperatura" + String(i+1));
        sensorObj["idMicrocontrolador"] = 1;
        sensorObj["idLocalizacao"] = 1;
        sensorObj["idSensor"] = i + 1;
        sensorObj["valorSensor"] = String(temperatureReadings[i]) + "°C";
      }
      for (int j = 0; j < numSensors; j++) {
        JsonObject sensorObj = jsonDoc.createNestedObject("Sensor de Umidade de Solo" + String(j+1));
        sensorObj["idMicrocontrolador"] = 1;
        sensorObj["idLocalizacao"] = 1;
        sensorObj["idSensor"] = j + 1;
        sensorObj["valorSensor"] = String(soilHumidityReadings[j]) + " ";
      }
      
      // Serializar o objeto JSON para uma string
      String jsonString;
      serializeJson(jsonDoc, jsonString);
      
      // Enviar a requisição POST com os dados JSON
      int httpResponseCode = http.POST(jsonString);
     
      Serial.print("HTTP Response code: ");
      Serial.println(httpResponseCode);
        
      http.end();
    }
    else {
      Serial.println("WiFi Disconnected");
    }
    lastTime = millis();
  }
}
void multiplex(){
  for (int x = 0; x <= 9; x++){
    for (int y = 0; y <= 9; y++){
      digitalWrite(mix[y], ci[x][y]);
    }
  
  valores_analogicos[x] = analogRead(SIG);
  delay(100);
  }
}