# Unit Testing practice project

The goal of this project is to get familiar with Unit testing and Continious Integration (Travis).




## Build project
In order to build the project execute the following Maven command:
```
mvn clean package jacoco:report
```
This command will also generate a report of the code coverage produced by JaCoCo. The report will be located in the following path for each module:
```
target/site/jacoco
```

## Test project
To simply run the unit tests of the project, execute the following Maven command: 
```
mvn test
```
***Important:*** Note that only classes with a ```Test``` suffix located in the ```src/test``` will be executed and reported as Tests.

## Generate Test-coverage report
In order to simply run the unit tests of the project but also generate a Test-coverage report execute the following Maven command: 
```
mvn test jacoco:report
```





## Authors

* **Dafni Theodorou** - *Initial work* - [dafnith](https://github.com/dafnith)

See also the list of [contributors](https://github.com/dafnith/maven-chart-project/contributors) who participated in this project.


