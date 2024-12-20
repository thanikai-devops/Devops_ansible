def call(String environment = "prod") {
    script {
       if (environment == "dev"){
        echo "Deploying to Development (dev) environment."
       }
       else (environment == "UAT"){
        echo "Deploying to Development (UAT) environment."
       }
       else (environment == "Prod"){
        echo "Deploying to prod environment"
       }
    }
}
