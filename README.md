###GUIDE

Starting it up
- `` docker-compose up -d``
- ``docker run -p 9200:9200   -e "discovery.type=single-node"   docker.elastic.co/elasticsearch/elasticsearch:7.10.0``
- start the server
APIs
- POST``localhost:8080/api/blog/send`` Send blog post to server
  - sample ``{
    "id":2,
    "post":"David is good"
    }``
- ``localhost:8080/api/blog/elk/find/{post}`` Search post from Elastic Search