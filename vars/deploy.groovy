def deploydocker(){
    // Application deploy into server using ansible
     dir("/opt/workspace/GooplusBuildDeploy/playbook"){
        sh "ansible-playbook -i inventory goodeploy.yml"
     }
}