pipeline {

    agent any

    stages {

        stage ('Git clone') {
            steps {
                git(
                    url: "https://github.com/Mikadows/Wallet.git",
                    branch: "${BRANCHE}"
                )
            }
        }

        stage ('Maven Test') {
            steps {
                sh "mvn test"
            }
        }

        stage ('Maven build') {
            steps {
                sh "mvn package"
            }
        }

        stage('Publish tests results') {
            parallel {
                stage('SonarQube analysis') {
                    steps{
                        withSonarQubeEnv('sonarqube') {
                            sh "/sonar-scanner/bin/sonar-scanner -Dproject.settings=sonar.properties"
                        }
                    }
                }
                stage('Publish cucumber report') {
                    steps {
                        cucumber buildStatus: "UNSTABLE",
                                 fileIncludePattern: '**/cucumber.json',
                                 jsonReportDirectory: 'target'
                    }
                }
            }
        }

//         stage('Generate cucumber report') {
//             steps {
//                 cucumber buildStatus: "UNSTABLE",
//                          fileIncludePattern: '**/cucumber.json',
//                          jsonReportDirectory: 'target'
//             }
//         }
    }
}