pipeline {
    agent { label 'slave1' } 
    stages {
        stage('checkout') {
            steps {
                sh 'git clone https://github.com/sanjay0288/weather-update.git'
            }
        }
        stage('Build') {
            steps {
                script {
                    sh 'mvn --version'
                    sh 'mvn clean install'
                }
            }
        }
        stage('Deploy to Tomcat') {
            steps {
                script {
                    def serverUrl = "35.154.163.101:8081"
                    def username = "sanj"
                    def password = "sanj"
                    def warFileName = "weather-forecast-app-1.0-SNAPSHOT.jar"
                    def warFilePath = "/home/slave1/workspace/bus_booking_Develop/target/weather-forecast-app-1.0-SNAPSHOT.jar"

                    sh "curl -v --user ${username}:${password} --upload-file ${warFilePath} ${serverUrl}/manager/text/deploy?path=/${warFileName}"
                }
            }
        }
    }

    post {
        success {
            echo "Deployment to Tomcat successful!"
        }
        failure {
            echo "Deployment to Tomcat failed!"
        }
    }
}
