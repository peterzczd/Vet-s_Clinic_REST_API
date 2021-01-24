Vet's Clinic Appointment Demo

To Run as a Spring Boot application

Using Maven plugin:

    mvn clean spring-boot:run
----------------------------------------------------------------

- allows customer to make an appointment with certain doctor at
certain date and time
- allows to list appointments of certain doctor for given day
- allows customer to cancel his appointment

-Lets assume that customers already exists in the application
- Lets assume that customers have to provide their 4 digit ID and 4 digit PIN
in order to make or cancel their appointment

REST Endpoints

1) allows customer to make an appointment with certain doctor at
   certain date and time

POST request to add new appointments - /api/v1/appointments
http://localhost:PORT/api/v1/appointments

Pass Body as JSON:

{ "appointmentDate": "2021-02-14", "appointmentStartTime":
"20:00:00", "appointmentEndTime": "21:00:00", "nameOfDoctor":
"Linus Torvalds", "status": "Booked", "patientName": "Roman
Nowak", "patientId": "1112", "patientPIN": "4555" }

2)  allows customer to cancel his appointment

PATCH request to update status of an appointment
/api/v1/appointments/{appointmentId}

http://localhost:PORT/api/v1/appointments/4

Pass Body as JSON:
{ "status": "Cancelled", "patientId": "1111",
"patientPIN": "2356"}

Then you can see cancelled appointment:
http://localhost:8080/api/v1/appointments?nameOfDoctor=/*here provide doctor's name*/

3)  allows to list appointments of certain doctor for given day
GET request to return specific appointments

http://localhost:PORT/api/v1/appointments?nameOfDoctor=Linus Torvalds