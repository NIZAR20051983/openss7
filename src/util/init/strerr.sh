#!/bin/sh
#
# @(#) $RCSfile$ $Name$($Revision$) $Date$
# Copyright (c) 2008-2009  Monavacon Limited <http://www.monavacon.com/>
# Copyright (c) 2001-2008  OpenSS7 Corporation <http://www.openss7.com/>
# Copyright (c) 1997-2000  Brian F. G. Bidulock <bidulock@openss7.org>
# All Rights Reserved.
#
# Distributed by OpenSS7 Corporation.  See the bottom of this script for copying
# permissions.
#
# These are arguments to update-rc.d ala chkconfig and lsb.  They are recognized
# by openss7 install_initd and remove_initd scripts.  Each line specifies
# arguments to add and remove links after the the name argument:
#
# strerr:	start and stop strerr facility
# update-rc.d:	stop 80 0 1 6 .
# config:	/etc/default/strerr
# processname:	strerr
# pidfile:	/var/run/strerr.pid
# probe:	false
# hide:		false
# license:	GPL
# description:	This STREAMS init script is part of Linux Fast-STREAMS.  It is \
#		responsible for starting and stopping the STREAMS error \
#		logger.  The STREAMS error logger should only be run under \
#		exceptional circumstances and this init script not activated \
#		automatically.
#
# LSB init script conventions
#
### BEGIN INIT INFO
# Provides: strerr
# Required-Start: streams
# Required-Stop: streams
# Default-Start: 4
# Default-Stop: 0 1 2 3 4 5 6
# X-UnitedLinux-Default-Enabled: yes
# Short-Description: start and stop strerr
# License: GPL
# Description:	This STREAMS init script is part of Linux Fast-STREAMS.  It is
#	responsible for starting and stopping the STREAMS error logger.  The
#	STREAMS error logger should only be run under exceptional circumstances
#	and this init script is not activated in any run level by default.
### END INIT INFO

PATH=/usr/local/sbin:/usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin
name='strerr'
config="/etc/default/$name"
processname="$name"
pidfile="/var/run/$processname.pid"
execfile="/usr/sbin/$processname"
desc="the STREAMS error logger"

[ -x $execfile ] || exit 0

# Specify defaults

STRERROPTIONS=
STRERR_MAILUID=
STRERR_DIRECTORY="/var/log/streams"
STRERR_BASENAME="error"
STRERR_OUTFILE=
STRERR_ERRFILE=
STRERR_LOGDEVICE="/dev/streams/clone/log"
STRERR_OPTIONS=

# Source config file
for file in $config ; do
    [ -f $file ] && . $file
done

RETVAL=0

umask 077

case :$VERBOSE in
    :no|:NO|:false|:FALSE|:0|:)
	redir='>/dev/null 2>&1'
	;;
    *)
	redir=
	;;
esac

build_options() {
    # Build up the options string
    STRERR_OPTIONS="-p $pidfile"
    [ -n "$STRERROPTIONS" ] && \
	STRERR_OPTIONS="${STRERR_OPTIONS:+$STRERR_OPTIONS }${STRERROPTIONS}"
    [ -n "$STRERR_MAILUID" ] && \
	STRERR_OPTIONS="${STRERR_OPTIONS:+$STRERR_OPTIONS }-a ${STRERR_MAILUID}"
    [ -n "$STRERR_DIRECTORY" ] && \
	STRERR_OPTIONS="${STRERR_OPTIONS:+$STRERR_OPTIONS }-d ${STRERR_DIRECTORY}"
    [ -n "$STRERR_BASENAME" ] && \
	STRERR_OPTIONS="${STRERR_OPTIONS:+$STRERR_OPTIONS }-b ${STRERR_BASENAME}"
    [ -n "$STRERR_OUTFILE" ] && \
	STRERR_OPTIONS="${STRERR_OPTIONS:+$STRERR_OPTIONS }-o ${STRERR_OUTFILE}"
    [ -n "$STRERR_ERRFILE" ] && \
	STRERR_OPTIONS="${STRERR_OPTIONS:+$STRERR_OPTIONS }-e ${STRERR_ERRFILE}"
    [ -n "$STRERR_LOGDEVICE" ] && \
	STRERR_OPTIONS="${STRERR_OPTIONS:+$STRERR_OPTIONS }-l ${STRERR_LOGDEVICE}"
}

start() {
    echo -n "Starting $desc: $name "
    [ -d "$STRERR_DIRECTORY" -o -z "$STRERR_DIRECTORY" ] || mkdir -p "$STRERR_DIRECTORY"
    build_options
    start-stop-daemon --start --quiet --pidfile $pidfile \
	--exec $execfile -- $STRERR_OPTIONS
    RETVAL=$?
    if [ $RETVAL -eq 0 ] ; then
	echo "."
    else
	echo "(failed.)"
    fi
    return $RETVAL
}

stop() {
    echo -n "Stopping $desc: $name "
    start-stop-daemon --stop --quiet --retry=1 --oknodo --pidfile $pidfile \
	--exec $execfile
    RETVAL=$?
    if [ $RETVAL -eq 0 ] ; then
	echo "."
    else
	echo "(failed.)"
    fi
    return $RETVAL
}

restart() {
    stop
    start
    return $?
}

reload() {
    echo -n "Reloading $desc: $name "
    start-stop-daemon --stop --quiet --signal=1 --pidfile $pidfile \
	--exec $execfile
    RETVAL=$?
    if [ $RETVAL -eq 0 ] ; then
	echo "."
    else
	echo "(failed.)"
    fi
    return $RETVAL
}

show() {
    echo "$name.sh: show: not yet implemented." >&2
    return 1
}

usage() {
    echo "Usage: /etc/init.d/$name.sh (start|stop|restart|reload|force-reload|show)" >&2
    return 1
}

case "$1" in
    (start|stop|reload|restart|show)
	$1 || RETVAL=$?
	;;
    (force-reload)
	reload || RETVAL=$?
	;;
    (*)
	usage || RETVAL=$?
	;;
esac

[ "${0##*/}" = "$name.sh" ] && exit $RETVAL

# =============================================================================
# 
# @(#) $RCSfile$ $Name$($Revision$) $Date$
#
# -----------------------------------------------------------------------------
#
# Copyright (c) 2008-2009  Monavacon Limited <http://www.monavacon.com/>
# Copyright (c) 2001-2008  OpenSS7 Corporation <http://www.openss7.com/>
# Copyright (c) 1997-2000  Brian F. G. Bidulock <bidulock@openss7.org>
#
# All Rights Reserved.
#
# This program is free software; you can redistribute it and/or modify it under
# the terms of the GNU Affero General Public License as published by the Free
# Software Foundation; version 3 of the License.
#
# This program is distributed in the hope that it will be useful, but WITHOUT
# ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
# FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more
# details.
#
# You should have received a copy of the GNU Affero General Public License along
# with this program.  If not, see <http://www.gnu.org/licenses/>, or write to
# the Free Software Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
#
# -----------------------------------------------------------------------------
#
# U.S. GOVERNMENT RESTRICTED RIGHTS.  If you are licensing this Software on
# behalf of the U.S. Government ("Government"), the following provisions apply
# to you.  If the Software is supplied by the Department of Defense ("DoD"), it
# is classified as "Commercial Computer Software" under paragraph 252.227-7014
# of the DoD Supplement to the Federal Acquisition Regulations ("DFARS") (or any
# successor regulations) and the Government is acquiring only the license rights
# granted herein (the license rights customarily provided to non-Government
# users).  If the Software is supplied to any unit or agency of the Government
# other than DoD, it is classified as "Restricted Computer Software" and the
# Government's rights in the Software are defined in paragraph 52.227-19 of the
# Federal Acquisition Regulations ("FAR") (or any successor regulations) or, in
# the cases of NASA, in paragraph 18.52.227-86 of the NASA Supplement to the FAR
# (or any successor regulations).
#
# -----------------------------------------------------------------------------
#
# Commercial licensing and support of this software is available from OpenSS7
# Corporation at a fee.  See http://www.openss7.com/
#
# -----------------------------------------------------------------------------
#
# Last Modified $Date$ by $Author$
#
# -----------------------------------------------------------------------------
#
# $Log$
# =============================================================================
# vim: ft=sh sw=4 tw=80