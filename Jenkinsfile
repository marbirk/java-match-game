#!groovy

node {
    stage('Check versions') {
        steps {
            sh 'node --version'
            sh 'mvn --version'
            sh 'java --version'
        }
    }
    stage("Cleanup") {
        cleanWs()
    }
    stage("Checkout") {
        checkout([
                $class: 'GitSCM', 
                branches: [[name: '*/master']], 
                doGenerateSubmoduleConfigurations: false, 
                extensions: [], 
                submoduleCfg: [], 
                userRemoteConfigs: [[url: 'https://github.com/marbirk/java-match-game']]
        ])
    }
    stage("Build") {
        def mvn_home = tool name: 'maven3', type: 'maven'
        sh "${mvn_home}/bin mvn package"
    }
    stage("Cleanup") {
        cleanWs()
    }
}
