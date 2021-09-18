import java.util.logging.Logger;

public class HtmlTextBody {
    private static Logger log = Logger.getLogger(HtmlTextBody.class.getName());

        private final String text;

        public HtmlTextBody(String text) {
            log.info("INFO send text");
            this.text = text;
        }

        public String getText() {
            log.info("INFO get Text");
            return text;
        }

}
