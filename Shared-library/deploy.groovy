def call (String environment = dev ){
    sh 'git config --global user.name "Your Jenkins User"'
    sh 'git config --global user.email "your-email@example.com"'
    
    // Perform the git tag operation or any other Git-related task
    sh 'git tag -a -f -m "Jenkins Build" my-tag'
    if (environment == dev){
        echo "Deploy in dev stage"
    }
    else (environment == UAT ){
        echo "Deploy in UAT stage"
    }
}