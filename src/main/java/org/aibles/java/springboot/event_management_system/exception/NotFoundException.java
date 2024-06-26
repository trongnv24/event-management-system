    package org.aibles.java.springboot.event_management_system.exception;

    import lombok.Data;

    import java.time.Instant;
    import java.util.Map;
    @Data
    public class NotFoundException extends RuntimeException{
        private String code;
        private Long timestamp;
        private Map<String, String> error;

        public NotFoundException(Map<String, String> error) {
            this.code = "not_found";
            this.timestamp = Instant.now().toEpochMilli();
            this.error = error;
        }
    }
