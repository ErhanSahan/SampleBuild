pipeline {
    agent { docker { image 'maven:3.3.3' } }
    stages {
        checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '5a91e258-8aeb-43f9-84c7-bae3e933415d', url: 'https://github.com/ErhanSahan/build.git']]])
      
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}
