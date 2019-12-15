#!groovy

node {
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
    stage("Cleanup") {
        cleanWs()
    }
}
