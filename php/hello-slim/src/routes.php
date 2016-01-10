<?php
// Routes

$app->get('/hello', function ($req, $res, $args) {
    
    $body = $res->getBody();
    $body->write('<h1>Hello Slim!</h1>');    

    return $res->withHeader(
        'Content-Type',
        'text/html'
    );
});


$app->get('/[{name}]', function ($request, $response, $args) {
    // Sample log message
    $this->logger->info("Slim-Skeleton '/' route");

    // Render index view
    return $this->renderer->render($response, 'index.phtml', $args);
});
