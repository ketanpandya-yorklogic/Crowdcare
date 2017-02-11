# Crowdcare
This repository contains code as part of candidate test at Crowdcare.

## Comments
Out of 4 tasks, I have not done the normalize query part as not really clear. Perhaps something simple.

Overall it was an intersting little project.  I never had reason to use Wikipedia directly as such and so interesting to learn the APIs.  The Java coding part was easy, figuring out the Wikipedia API is where I had to spend most of the time.  It did take more than few hours and mostly on API search/trails and some on setting up local env.

I am sure improvements can be made.

##Steps

### Prerequisite
Java 1.6+, Latest version of maven installed

### Download
1. Do Git pull to a directory  e.g c:\temp\mygit
2. cd to the donwload directory

### Build
mvn compile

### Running
1-Task (1) and (2) combined. Execute "mvn exec:java"

2- Task (4), execute "mvn -f pom_rest.xml exec:java" and then use browser or postman tool and navigate to "http://localhost:8080/api/query/Canada"  This should return an array of JSON objects





