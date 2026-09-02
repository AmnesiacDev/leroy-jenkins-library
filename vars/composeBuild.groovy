def call(String service_name){
  try{
    sh "docker compose build ${service_name}"
  }catch (err){
    currentBuild.result = 'FAILURE'
    error("ERROR: failed at Build with -> ${err}")
  }
}
