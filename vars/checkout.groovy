def call(String project) {
    // Get the Git configuration for the project
    def config = gitconfig(project)

    if (config == null) {
        error "No valid Git configuration found for project: ${project}"
    }
    echo "Checking out repository: ${config.git_url} on branch ${config.git_branch}"
    git credentials: config.git_credentials, url: config.git_url, branch: config.git_branch    
    echo "Checkout Successful"
}


