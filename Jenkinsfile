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
    }
}