def call(String service_name){
  try{
        sh """
              docker compose up -d "${service_name}"
          """
  }catch (err){
        currentBuild.result = 'FAILURE'
        error("ERROR: failed at Deploy with -> ${err}")
  }
}
