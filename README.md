# maven-chart-project

A java project that creates a histogram based on a file with grades.


## Getting Started

These instructions will get you a copy of the project up and running on your local machine. Bellow are the steps to install and run the project.

### Prerequisites

1. In order to buid and run this project you need to have Java and Maven installed in your local machine.
    - Learn how to download and install [Java JDK 8](https://www.guru99.com/install-java.html) and [Maven](http://maven.apache.org/install.html).
    - You can check the Java and Maven version by typing in the command line `java -version` and `mvn -v`

2. You should also have a file with grades on your local machine where each grade must be in a different line.

### Installing

First of all you have to clone the repository. You can also download the repository as zip.
Clone the repository by typing in the command line

```
git clone https://github.com/dafnith/maven-chart-project.git
```

### Building the project

Execute the following command in the repository root directory in order to build all modules.
```
mvn package
```

### Running the project

In order to run the project in the command line go to repository's root directory (your local directory where you cloned the project) and type

```
java -jar seip2020_practical_assignments/gradeshistogram/target/gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies.jar <grades file path>
```

A new window showing a graph should open.




## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Contributing

This is a private repository that only collaborators can contribute to.


## Authors

* **Dafni Theodorou** - *Initial work* - [dafnith](https://github.com/dafnith)

See also the list of [contributors](https://github.com/dafnith/maven-chart-project/contributors) who participated in this project.


