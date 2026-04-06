pipeline {
    agent any

    tools {
        maven 'Maven' // Adjust tool name based on Jenkins configuration
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building and Packaging Spring Boot Project'
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests'
                sh 'mvn test'
            }
        }
    }
}
