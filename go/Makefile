PROGRAMS:=hello true false echo cat

.PHONY: all
all: $(PROGRAMS)

%: %.go
	go build $^

.PHONY: clean
clean:
	$(RM) $(PROGRAMS)
