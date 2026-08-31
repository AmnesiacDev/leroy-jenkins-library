def call(String service_name){
  sh "docker compose build ${service_name}"
}
