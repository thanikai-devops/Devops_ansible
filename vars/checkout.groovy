def call(String project) {
    // Get the Git configuration for the project
    def config = gitconfig(project)

    if (config == null) {
        error "No valid Git configuration found for project: ${project}"
    }
    echo "Checking out repository: ${config.git_url} on branch ${config.git_branch}"
    git credentialsId: config.git_credentialsId, url: config.git_url, branch: config.git_branch    
    echo "Checkout Successful"
}


// For Single Project Approach
// def call(String gitUrl , String gitbranch , String credentialsId){
//     echo "Using Bitbucket Credentials for gooplus repository for Backend"
//     echo "Checking Out repository: ${gitUrl} on branch ${gitbranch}"

//     // git_credentialsId: credentialsId , url: giturl , branch: gitbranch
//     echo "Checkout Successful"
// }