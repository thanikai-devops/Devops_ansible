// Deployment Application in Application server Using ansible 
def ansibledeploymentIntoServer(String inventory="../playbook/hosts" , String playbook){
    sh "ansible-playbook -i ${inventory} ${playbook}"

}