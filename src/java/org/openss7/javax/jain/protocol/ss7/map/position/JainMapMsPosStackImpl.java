
package org.openss7.javax.jain.protocol.ss7.map.position;

import javax.jain.protocol.ss7.map.position.*;
import javax.jain.protocol.ss7.map.*;
import javax.jain.protocol.ss7.*;
import javax.jain.*;

public class JainMapMsPosStackImpl implements JainMapMsPosStack {
    public native MsPosProvider createMsPosProvider()
        throws SS7PeerUnavailableException;
    public native void deleteMsPosProvider(MsPosProvider provider);
}


// vim: sw=4 et tw=0 com=srO\:/**,mb\:*,ex\:*/,srO\:/*,mb\:*,ex\:*/,b\:TRANS,\://,b\:#,\:%,\:XCOMM,n\:>,fb\:-