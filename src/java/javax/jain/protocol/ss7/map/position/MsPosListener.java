

package javax.jain.protocol.ss7.map.position;

import javax.jain.protocol.ss7.map.*;
import javax.jain.protocol.ss7.*;
import javax.jain.*;
import java.util.EventListener;

public interface MsPosListener extends EventListener {
    public void processMsPosEvent(MsPosConfEvent event, long transactionId);
    public void processMsPosEvent(MsPosIndEvent event, long transactionId);
    public void processMsPosEvent(MsPosReportIndEvent event, long transactionId);
    public void processMapError(MapErrorEvent error);
}

// vim: sw=4 et tw=0 com=srO\:/**,mb\:*,ex\:*/,srO\:/*,mb\:*,ex\:*/,b\:TRANS,\://,b\:#,\:%,\:XCOMM,n\:>,fb\:-