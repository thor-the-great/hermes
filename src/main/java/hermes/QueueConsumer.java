package hermes;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {

    protected Logger logger = LoggerFactory.getLogger(getClass());
    public void receiveMessage(String message) {
        logger.info("Received (String) " + message);
        processMessage(message);
    }
    public void receiveMessage(byte[] message) {
        String strMessage = new String(message);
        logger.info("Received (No String) " + strMessage);
        processMessage(strMessage);
    }
    private void processMessage(String message) {
        try {
            logger.warn("Message received " + message);
        } catch (JsonParseException e) {
            logger.warn("Bad JSON in message: " + message);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}