def deploydocker(String playbook, String ansible_dir){
    // Application deploy into server using ansible
     sh """
     cd /opt/workspace/${ansible_dir}
     ansible-playbook ${playbook}
     """
}