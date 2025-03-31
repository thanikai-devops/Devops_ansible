def ansibledeploymentIntoServer(String inventory , String playbook){
    sh "ansible-playbook -i ${inventory} ${playbook}"

}