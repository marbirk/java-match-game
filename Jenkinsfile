#!groovy

node {
    stage("Clean Up") {
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
        sh "mvn package"
    }
    stage("Clean Up") {
        cleanWs()
    }
}
