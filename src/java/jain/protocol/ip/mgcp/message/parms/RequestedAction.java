// vim: sw=4 et tw=72 com=srO\:/**,mb\:*,ex\:*/,srO\:/*,mb\:*,ex\:*/,b\:TRANS,\://,b\:#,\:%,\:XCOMM,n\:>,fb\:-
/*
 @(#) $RCSfile$ $Name$($Revision$) $Date$ <p>
 
 Copyright &copy; 2008-2009  Monavacon Limited <a href="http://www.monavacon.com/">&lt;http://www.monavacon.com/&gt;</a>. <br>
 Copyright &copy; 2001-2008  OpenSS7 Corporation <a href="http://www.openss7.com/">&lt;http://www.openss7.com/&gt;</a>. <br>
 Copyright &copy; 1997-2001  Brian F. G. Bidulock <a href="mailto:bidulock@openss7.org">&lt;bidulock@openss7.org&gt;</a>. <p>
 
 All Rights Reserved. <p>
 
 This program is free software: you can redistribute it and/or modify it under
 the terms of the GNU Affero General Public License as published by the Free
 Software Foundation, version 3 of the license. <p>
 
 This program is distributed in the hope that it will be useful, but <b>WITHOUT
 ANY WARRANTY</b>; without even the implied warranty of <b>MERCHANTABILITY</b>
 or <b>FITNESS FOR A PARTICULAR PURPOSE</b>.  See the GNU Affero General Public
 License for more details. <p>
 
 You should have received a copy of the GNU Affero General Public License along
 with this program.  If not, see
 <a href="http://www.gnu.org/licenses/">&lt;http://www.gnu.org/licenses/&gt</a>,
 or write to the Free Software Foundation, Inc., 675 Mass Ave, Cambridge, MA
 02139, USA. <p>
 
 <em>U.S. GOVERNMENT RESTRICTED RIGHTS</em>.  If you are licensing this
 Software on behalf of the U.S. Government ("Government"), the following
 provisions apply to you.  If the Software is supplied by the Department of
 Defense ("DoD"), it is classified as "Commercial Computer Software" under
 paragraph 252.227-7014 of the DoD Supplement to the Federal Acquisition
 Regulations ("DFARS") (or any successor regulations) and the Government is
 acquiring only the license rights granted herein (the license rights
 customarily provided to non-Government users).  If the Software is supplied to
 any unit or agency of the Government other than DoD, it is classified as
 "Restricted Computer Software" and the Government's rights in the Software are
 defined in paragraph 52.227-19 of the Federal Acquisition Regulations ("FAR")
 (or any successor regulations) or, in the cases of NASA, in paragraph
 18.52.227-86 of the NASA Supplement to the FAR (or any successor regulations). <p>
 
 Commercial licensing and support of this software is available from OpenSS7
 Corporation at a fee.  See
 <a href="http://www.openss7.com/">http://www.openss7.com/</a> <p>
 
 Last Modified $Date$ by $Author$
 */

package jain.protocol.ip.mgcp.message.parms;

// vim: sw=4 et tw=72 com=srO\:/**,mb\:*,ex\:*/,srO\:/*,mb\:*,ex\:*/,b\:TRANS,\://,b\:#,\:%,\:XCOMM,n\:>,fb\:-
/*

   Overview  Package   Class  Tree  Index  Help
   JAIN^TM MGCP API (Final Release) - Version 1.0
    PREV CLASS   NEXT CLASS FRAMES    NO FRAMES
   SUMMARY:  INNER | FIELD | CONSTR | METHOD DETAIL:
   FIELD | CONSTR | METHOD
     _________________________________________________________________

jain.protocol.ip.mgcp.message.parms
Class RequestedAction

java.lang.Object
  |
  +--jain.protocol.ip.mgcp.message.parms.RequestedAction

   All Implemented Interfaces:
          java.io.Serializable
     _________________________________________________________________

   public final class RequestedAction
   extends java.lang.Object
   implements java.io.Serializable

   Specifies a Requested Action, as defined in RFC 2705.

   See Also: 
          Serialized Form
     _________________________________________________________________

   Field Summary
   static RequestedAction Accumulate
             Encapsulates the ACCUMULATE constant.
   static int ACCUMULATE
             Signifies the "Accumulate" action.
   static int EMBEDDED_NOTIFICATION_REQUEST
             Signifies the "Embedded Notification Request" action
   static RequestedAction EmbeddedNotificationRequest
             Encapsulates the EMBEDDED_NOTIFICATION_REQUEST constant.
   static RequestedAction Ignore
             Encapsulates the IGNORE constant.
   static int IGNORE
             Signifies the "Ignore" action.
   static int KEEP_SIGNALS_ACTIVE
             Signifies the "Keep Signal(s) active" action.
   static RequestedAction KeepSignalsActive
             Encapsulates the KEEP_SIGNALS_ACTIVE constant.
   static int NOTIFY_IMMEDIATELY
             Signifies the "Notify immediately" action.
   static RequestedAction NotifyImmediately
             Encapsulates the NOTIFY_IMMEDIATELY constant.
   static RequestedAction Swap
             Encapsulates the SWAP constant.
   static int SWAP
             Signifies the "Swap" action.
   static int TREAT_ACCORDING_TO_DIGIT_MAP
             Signifies the "Treat according to digit map" action.
   static RequestedAction TreatAccordingToDigitMap
             Encapsulates the TREAT_ACCORDING_TO_DIGIT_MAP constant.



   Constructor Summary
   RequestedAction(EmbeddedRequest embeddedRequest)
             Constructs a new Requested Action that contains an embedded
   request.



   Method Summary
    EmbeddedRequest getEmbeddedRequest()
             Gets the embedded request.
    int getRequestedAction()
             Gets the constant that represents this requested action.
    java.lang.String toString()
             Returns a java.lang.String of the form
   "N|A|D|S|I|K|E(<embeddedRequest>)" where <embeddedRequest> is an
   embedded request (see EmbeddedRequest for more information about the
   form the embedded request java.lang.String takes.



   Methods inherited from class java.lang.Object
   clone, equals, finalize, getClass, hashCode, notify, notifyAll, wait,
   wait, wait



   Field Detail

  Accumulate

public static final RequestedAction Accumulate

          Encapsulates the ACCUMULATE constant.
     _________________________________________________________________

  ACCUMULATE

public static final int ACCUMULATE

          Signifies the "Accumulate" action.
     _________________________________________________________________

  EMBEDDED_NOTIFICATION_REQUEST

public static final int EMBEDDED_NOTIFICATION_REQUEST

          Signifies the "Embedded Notification Request" action
     _________________________________________________________________

  EmbeddedNotificationRequest

public static final RequestedAction EmbeddedNotificationRequest

          Encapsulates the EMBEDDED_NOTIFICATION_REQUEST constant.
     _________________________________________________________________

  Ignore

public static final RequestedAction Ignore

          Encapsulates the IGNORE constant.
     _________________________________________________________________

  IGNORE

public static final int IGNORE

          Signifies the "Ignore" action.
     _________________________________________________________________

  KEEP_SIGNALS_ACTIVE

public static final int KEEP_SIGNALS_ACTIVE

          Signifies the "Keep Signal(s) active" action.
     _________________________________________________________________

  KeepSignalsActive

public static final RequestedAction KeepSignalsActive

          Encapsulates the KEEP_SIGNALS_ACTIVE constant.
     _________________________________________________________________

  NOTIFY_IMMEDIATELY

public static final int NOTIFY_IMMEDIATELY

          Signifies the "Notify immediately" action.
     _________________________________________________________________

  NotifyImmediately

public static final RequestedAction NotifyImmediately

          Encapsulates the NOTIFY_IMMEDIATELY constant.
     _________________________________________________________________

  Swap

public static final RequestedAction Swap

          Encapsulates the SWAP constant.
     _________________________________________________________________

  SWAP

public static final int SWAP

          Signifies the "Swap" action.
     _________________________________________________________________

  TREAT_ACCORDING_TO_DIGIT_MAP

public static final int TREAT_ACCORDING_TO_DIGIT_MAP

          Signifies the "Treat according to digit map" action.
     _________________________________________________________________

  TreatAccordingToDigitMap

public static final RequestedAction TreatAccordingToDigitMap

          Encapsulates the TREAT_ACCORDING_TO_DIGIT_MAP constant.

   Constructor Detail

  RequestedAction

public RequestedAction(EmbeddedRequest embeddedRequest)

          Constructs a new Requested Action that contains an embedded
          request.

        Parameters:
                embeddedRequest - The embedded request.

   Method Detail

  getEmbeddedRequest

public EmbeddedRequest getEmbeddedRequest()

          Gets the embedded request.

        Returns:
                The embedded request, or null, if this requested action
                does not contain an embedded request.
     _________________________________________________________________

  getRequestedAction

public int getRequestedAction()

          Gets the constant that represents this requested action.

        Returns:
                One of constants defined above that represent requested
                actions.
     _________________________________________________________________

  toString

public java.lang.String toString()

          Returns a java.lang.String of the form "N|A|D|S|I|K|E(<embeddedRequest>)"
          where <embeddedRequest> is an embedded request (see
          EmbeddedRequest for more information about the form the
          embedded request java.lang.String takes.

        Overrides:
                toString in class java.lang.Object
     _________________________________________________________________

   Overview  Package   Class  Tree  Index  Help
   JAIN^TM MGCP API (Final Release) - Version 1.0
    PREV CLASS   NEXT CLASS FRAMES    NO FRAMES
   SUMMARY:  INNER | FIELD | CONSTR | METHOD DETAIL:
   FIELD | CONSTR | METHOD
     _________________________________________________________________

                  Copyright � 2000 Sun Microsystems, Inc.
*/