package com.example;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rx.Observable;

@RestController
public class Endpoint {

	@GetMapping(path = "/get")
	public HttpEntity<String> get() {
		return new HttpEntity<String>("Eisai megali lougkra");
	}

	@GetMapping(path = "/eisai", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Observable<String> getFather(@RequestParam(name="ti") String ti) {
		Observable<Long> interval = Observable.interval(1000, TimeUnit.MILLISECONDS);
		Observable<String> trashing = Observable.from(new String[]{"Niko", "eisai", "megali", ti});
		return Observable.zip(interval, trashing, (a,b)->b);
	}
}
