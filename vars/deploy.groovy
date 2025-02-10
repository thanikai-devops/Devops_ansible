def deploydocker(){
    // Application deploy into server using ansible
     sh """source ansible/bin/activate
     cd /opt/workspace/GooplusBuildDeploy/playbook
     ansible-playbook goodeploy.yml
     """
}