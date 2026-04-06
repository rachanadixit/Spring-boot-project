pipeline {
    agent { label 'Jenkins-Worker-01' }

    triggers {
        githubPush()
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                credentialsId: 'github-creds',
                url: 'https://github.com/rachanadixit/Spring-boot-project.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                fuser -k 8081/tcp || true
                nohup java -jar target/*.jar > app.log 2>&1 &
                '''
            }
        }
    }

    post {
        success {
            echo 'Build Success'
        }
        failure {
            echo 'Build Failed'
        }
    }
}
