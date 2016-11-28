# CBilling
A Common billing application which can be used in any industry
#BillingService
Billing Service is the service part which will run on Jetty server. We use gradle as dependancy manager. 
So please follow below commands to configure gradle in your workstation.

#Gradle Build Command For Service####
Go to the service Project named [BillingService] folder 
cd BillingService
On Linux
./gradlew build
On Windows
gradlew build

After build command a jar file will be created in BillingService/build/libs/billing-app-rest-service-0.1.0.jar

To start jetty server run the following command

java -jar build/libs/billing-app-rest-service-0.1.0.jar
