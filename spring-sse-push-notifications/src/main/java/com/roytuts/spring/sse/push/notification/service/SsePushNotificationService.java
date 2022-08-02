package com.roytuts.spring.sse.push.notification.service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
@EnableScheduling
public class SsePushNotificationService {

	final DateFormat DATE_FORMATTER = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
	final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

	private int contador = 0;
	public void addEmitter(final SseEmitter emitter) {
		emitters.add(emitter);
	}

	public void removeEmitter(final SseEmitter emitter) {
		emitters.remove(emitter);
	}

	@Async
	@Scheduled(fixedRate = 15000)
	public void doNotify() throws IOException {
		List<SseEmitter> deadEmitters = new ArrayList<>();
		
		
		
		emitters.forEach(emitter -> {
			try {
				emitter.send(SseEmitter.event()
						.data(DATE_FORMATTER.format(new Date()) + " : " + UUID.randomUUID().toString()));
				System.out.print("entro por aqui");
			} catch (Exception e) {
				deadEmitters.add(emitter);
			}
		});
		System.out.print("entro por aqui" + "\n" + contador ++);
		emitters.removeAll(deadEmitters);
	}

}
