pipeline{
    agent any
    tools{
        maven 'maven_local_10'
        jdk 'java_local_11'
    }
    stages{
        stage('Build Backend'){
            steps{
                sh 'mvn clean package -Dmaven.test.skip=true'
            }
        }
        stage('Unit Tests'){
            steps{
                sh 'mvn test'
            }
        }
        stage('Sonar Scanner'){
            environment{
            scannerHome = tool 'sonarqube-scanner'
            }
            steps{
                withSonarQubeEnv('sonar_local'){
                    sh "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=DeployCeperizador -Dsonar.host.url=http://localhost:9000 -Dsonar.login=6924e6b6ade4e32683547e2cc9d0cc83f07a5a53 -Dsonar.java.binaries=target"
                }
            }
        }
    }
}

