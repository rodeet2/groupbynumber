
## Group By Number

### Demo: http://groupbynumber.com/

A simple web app to help create groups. It replicates the process of round-robin assignment or circular counting. Where users can scan a qr code to get their group number.

#### Group making & features

In this method, individuals are assigned a group number in sequence. Counting let's say from 1 to 4, then counting from 1 to 4 again, untill everyone has a number. 
Here, the user gets a number or the count increases when somone scans the group qr code.
App ask for number of groups and total users, then a qr code is created. No login or accounts required. Every group making session has a ID and information is saved in the database. 

### Made with and Structure

This is a basic springboot web app. It connects to a MySql database to store most group information. Every group has a group ID, which is also the specific url, with which the qr code link is made. Opensource API is used to convert the url to a qr code image.

### Setup and Requirements 

The project will need login details to MySql in the application.properties, along with the dependencies of springboot. 

### Status

Current plans would include working with the total memebers limt, and a live update of information on the group under the qr code. Such as number of total members, and also perhaps a list that of the users that updates live. 
