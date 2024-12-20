def call(String environment ) {
    script {
       if (environment == "dev"){
        echo "Deploying to Development (dev) environment."
       }
       else if (environment == "UAT"){
        echo "Deploying to Development (UAT) environment."
       }
       else if (environment == "Prod"){
        echo "Deploying to prod environment"
       }
    }
}
