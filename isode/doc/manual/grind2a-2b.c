/*****************************************************************************

 @(#) $RCSfile$ $Name$($Revision$) $Date$

 -----------------------------------------------------------------------------

 Copyright (c) 2001-2007  OpenSS7 Corporation <http://www.openss7.com/>
 Copyright (c) 1997-2000  Brian F. G. Bidulock <bidulock@openss7.org>

 All Rights Reserved.

 This program is free software: you can redistribute it and/or modify it under
 the terms of the GNU General Public License as published by the Free Software
 Foundation, version 3 of the license.

 This program is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more
 details.

 You should have received a copy of the GNU General Public License along with
 this program.  If not, see <http://www.gnu.org/licenses/>, or write to the
 Free Software Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.

 -----------------------------------------------------------------------------

 U.S. GOVERNMENT RESTRICTED RIGHTS.  If you are licensing this Software on
 behalf of the U.S. Government ("Government"), the following provisions apply
 to you.  If the Software is supplied by the Department of Defense ("DoD"), it
 is classified as "Commercial Computer Software" under paragraph 252.227-7014
 of the DoD Supplement to the Federal Acquisition Regulations ("DFARS") (or any
 successor regulations) and the Government is acquiring only the license rights
 granted herein (the license rights customarily provided to non-Government
 users).  If the Software is supplied to any unit or agency of the Government
 other than DoD, it is classified as "Restricted Computer Software" and the
 Government's rights in the Software are defined in paragraph 52.227-19 of the
 Federal Acquisition Regulations ("FAR") (or any successor regulations) or, in
 the cases of NASA, in paragraph 18.52.227-86 of the NASA Supplement to the FAR
 (or any successor regulations).

 -----------------------------------------------------------------------------

 Commercial licensing and support of this software is available from OpenSS7
 Corporation at a fee.  See http://www.openss7.com/

 -----------------------------------------------------------------------------

 Last Modified $Date$ by $Author$

 -----------------------------------------------------------------------------

 $Log$
 *****************************************************************************/

#ident "@(#) $RCSfile$ $Name$($Revision$) $Date$"

static char const ident[] = "$RCSfile$ $Name$($Revision$) $Date$";

...static int
ros_init(vecp, vec)
	int vecp;
	char **vec;
{
	int sd;
	struct AcSAPstart acss;
	register struct AcSAPstart *acs = &acss;
	struct AcSAPindication acis;
	register struct AcSAPindication *aci = &acis;
	register struct AcSAPabort *aca = &aci->aci_abort;
	register struct PSAPstart *ps = &acs->acs_start;
	struct RoSAPindication rois;
	register struct RoSAPindication *roi = &rois;
	register struct RoSAPpreject *rop = &roi->roi_preject;

	if (AcInit(vecp, vec, acs, aci) == NOTOK) {
		warn("initialization fails: %s", AcErrString(aca->aca_reason));
		return NOTOK;
	}

	sd = acs->acs_sd;
	ACSFREE(acs);

/* read command line arguments here... */

	if (AcAssocResponse(sd, ACS_ACCEPT, ACS_USER_NULL, NULLOID, NULLAEI,
			    &ps->ps_called, NULLPC, ps->ps_defctxresult,
			    ps->ps_prequirements, ps->ps_srequirements,
			    SERIAL_NONE, ps->ps_settings, &ps->ps_connect,
			    NULLPEP, 0, aci) == NOTOK) {
		warn("A-ASSOCIATE.RESPONSE: %s", AcErrString(aca->aca_reason));
		return NOTOK;
	}

	if (RoSetService(sd, RoPService, roi) == NOTOK)
		fatal("RoSetService: %s", RoErrString(rop->rop_reason));

	return sd;
}

...