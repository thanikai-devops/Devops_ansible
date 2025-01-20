def gitcheckout(String repourl,String branch,String credentialsId="BitbucketRepo") {
    // Dynamic Checkout Branch 
    echo "Checking out from repo: ${repourl}, branch: ${branch} with credentials: ${credentialsId}"
    checkout([
        $class: "GitSCM",
        branches: [[name: "*/${branch}"]],
        userRemoteConfigs: [[
            url: repourl,
            credentialsId: credentialsId
        ]]
    ])
}
def ansiblecheckout(String ansibleurl="https://github.com/thanikai-devops/Devops_ansible.git" ,
 String branch = "feature-jenkins" , String credentialsId="devopsrepo"){
    // Static Ansible Url and branch
    echo "Checking out from Repo: ${ansibleurl}"
    checkout([
        $class: "GitSCM",
        branches: [[name: "*/${branch}"]],
        userRemoteConfigs: [[
            url: ansibleurl,
            credentialsId: credentialsId
        ]]
    ])
 }

