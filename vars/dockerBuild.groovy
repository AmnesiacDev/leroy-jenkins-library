def call (String image_name, String build_num){
  sh """
    pwd
    ls -la
    echo '----'
    ls -la ..
    docker build -t ${image_name}:${build_num} .
  """
}
