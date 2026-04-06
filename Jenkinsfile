pipeline {
    agent { label 'Jenkins-Worker-01' }

    triggers {
        githubPush()
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Pulling latest code...'
                git branch: 'main',
                url: 'https://github.com/rachanadixit/Spring-boot-project.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building project using Maven...'
                bat 'C:\\maven\\bin\\mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'C:\\maven\\bin\\mvn test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                bat '''
                taskkill /F /IM java.exe || exit 0
                start java -jar target\\*.jar
                '''
            }
        }
    }

    post {
        success {
            echo 'Build Success: Application Deployed!'
        }
        failure {
            echo 'Build Failed!'
        }
    }
}
