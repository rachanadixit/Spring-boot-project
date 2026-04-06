pipeline {
    agent { label 'Jenkins-Worker-01' }

    triggers {
        githubPush()
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Pulling latest code from GitHub...'
                git branch: 'main',
                url: 'https://github.com/rachanadixit/Spring-boot-project.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building project (creating JAR)...'
                bat 'C:\\maven\\bin\\mvn clean package'
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
                echo 'Deploying application on port 8081...'
                bat '''
                taskkill /F /IM java.exe || exit 0
                cd target
                start cmd /c "java -jar *.jar > app.log 2>&1"
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
