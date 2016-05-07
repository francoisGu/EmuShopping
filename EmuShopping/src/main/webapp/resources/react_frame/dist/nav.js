/**
 *
 * Created by litaoshen on 14/09/2015.
 */

var TabsExample = React.createClass({displayName: "TabsExample",
  getInitialState: function () {
    return {
      tabs: [
        {id: "navbar_home", title: 'Home', content: 'Content 2', url: '/'},
        {
          id: "navbar_product",
          title: 'Products',
          content: 'Content 1',
          url: '/product/list'
        }
      ],
      active: $("[content]").attr("content")==="shoppingHome.jsp"? 0:1
    };
  },
  render: function () {
    return React.createElement("div", null, 
      React.createElement(TabsSwitcher, {items: this.state.tabs, active: this.state.active, 
                    onTabClick: this.handleTabClick})
    );
  },

//<TabsContent items={this.state.tabs} active={this.state.active}/>

  handleTabClick: function (index) {
    this.setState({active: index})
  }
});

var TabsSwitcher = React.createClass({displayName: "TabsSwitcher",
  render: function () {
    var active = this.props.active;
    var items = this.props.items.map(function (item, index) {
      return React.createElement("li", {key: item.id, 
                 className:  item.id + ' ' + (active === index ? 'active' : '')}, 
        React.createElement("a", {href: item.url, onClick: this.onClick.bind(this, index)}, 
          item.title
        ));
    }.bind(this));

    return React.createElement("ul", {id: "navbar_item", className: "nav navbar-nav"}, items);
  },
  onClick: function (index) {
    this.props.onTabClick(index);
  }
});

//var TabsContent = React.createClass({
//    render: function () {
//        var active = this.props.active;
//        var items = this.props.items.map(function (item, index) {
//            return $('#body').html()
//        });
//        return <div>{items}</div>;
//    }
//});

React.render(
  React.createElement(TabsExample, null),
  document.getElementById("navbar_content")
);
