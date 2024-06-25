    package org.aibles.java.springboot.event_management_system.exception;

    import lombok.Data;

    import java.time.Instant;
    import java.util.Map;

    @Data
    public class NotFoundException extends RuntimeException{
        private String code;
        private Long timestamp;
        private Map<String, String>  details;

        public NotFoundException(Map<String, String>  details) {
            super(details.get("message"));
            this.details = details;
            this.code = "not_found";
            this.timestamp = Instant.now().toEpochMilli();

        }
    }
