.DELETE_ON_ERROR:

CFLAGS?=
LDFLAGS?=
LDLIBS?=
LOADLIBES?=
TARGET_ARCH?=

override CPPFLAGS+=-MMD -MT "$*.d $*.o" -DFILE=FID_$${MODULE^^}

SHELL:=bash
export SHELLOPTS:=errexit:pipefail
sources:=$(shell find -name "*.c")

%.d %.o: export MODULE=$*

all: foo

foo: foo.o $(sources:.c=.o)

-include $(sources:.c=.d)

clean:
	rm -f foo $(sources:.c=.o) $(sources:.c=.d)
